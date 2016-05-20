package com.example.dynamic.contract;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.dynamic.entity.ContractFieldRopChild;
import com.example.dynamic.entity.ContractFieldRopResult;
import com.example.dynamic.util.HttpUtil;
import com.example.sg.myproject.R;

import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContractActivity extends ActionBarActivity {

    public static final String TAG = "ContractActivity";
    List<ContractFieldRopResult> lists = new ArrayList<>();
    int currentFragment = 0;

    public void setLists(List<ContractFieldRopResult> lists) {
        this.lists = lists;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);
/*        Thread thread = new Thread(networkTask);
        thread.start();*/
        initVariable(getJsonStr());
        initComponent();
    }

    /**
     * 加载数据
     */
    private void loadData() {
        String str = HttpUtil.getResult("http://192.168.40.174:8080/app/service?v=1.0&appKey=00001&format=json&method=incito.contract.contractField.list&type=add&orderId=118");
        Log.d(TAG, str);

        Message msg = new Message();
        Bundle data = new Bundle();
        data.putString("json", str);
        msg.setData(data);
        handler.sendMessage(msg);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String str = data.getString("json");
            initVariable(str);
            initComponent();
        }
    };

    /**
     * 网络操作相关的子线程
     */
    Runnable networkTask = new Runnable() {

        @Override
        public void run() {
            // TODO
            // 在这里进行 http request.网络请求相关操作
            loadData();
        }
    };

    private void initComponent() {
        ContractActivityFragment fragment = new ContractActivityFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("list",(Serializable)lists);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.layout, fragment);
        transaction.commit();

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(v -> {
            FragmentTransaction transaction2 = fragmentManager.beginTransaction();
            if (currentFragment == 0) {
                button.setText(getResources().getString(R.string.back));
                setLists(fragment.getLists());
                bundle.putSerializable("list", (Serializable) lists);
                ContractFragment contractFragment = ContractFragment.newInstance(bundle);
                transaction2.replace(R.id.layout, contractFragment);
                currentFragment++;
            } else if (currentFragment == 1) {
                bundle.putSerializable("list", (Serializable) lists);
                fragment.setArguments(bundle);
                transaction2.replace(R.id.layout, fragment);
                button.setText(getResources().getString(R.string.finish));
                currentFragment--;
            }
            transaction2.commit();
        });
    }

    /**
     */
    private void initVariable(String str) {
        try {
            JSONObject jsonObject = new JSONObject(str);
            JSONObject jsonObject1 = jsonObject.getJSONObject("result");
            JSONArray jsonArray = jsonObject1.getJSONArray("contractFieldRopList");
            Log.d(TAG, jsonArray.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                ContractFieldRopResult contractFieldRopResult = new ContractFieldRopResult();
                contractFieldRopResult.setId(jsonObject2.getLong("id"));
                contractFieldRopResult.setField_type(jsonObject2.getString("field_type"));
                contractFieldRopResult.setName(jsonObject2.getString("name"));
                contractFieldRopResult.setOrderby(jsonObject2.getInt("orderby"));
                JSONArray jsonArray1 = jsonObject2.getJSONArray("children");
                if (jsonArray1 != null && jsonArray1.length() > 0) {
                    List<ContractFieldRopChild> contractFieldRopChildrens = new ArrayList<>();
                    for (int j = 0; j < jsonArray1.length(); j++) {
                        JSONObject jsonObject3 = jsonArray1.getJSONObject(j);
                        ContractFieldRopChild contractFieldRopChild = new ContractFieldRopChild();
                        contractFieldRopChild.setId(jsonObject3.getLong("id"));
                        contractFieldRopChild.setField_type(jsonObject3.getString("field_type"));
                        contractFieldRopChild.setName(jsonObject3.getString("name"));
                        contractFieldRopChild.setOrderby(jsonObject3.getInt("orderby"));
                        contractFieldRopChildrens.add(contractFieldRopChild);
                    }
                    contractFieldRopResult.setChildren(contractFieldRopChildrens);
                }
                lists.add(contractFieldRopResult);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     */
    public String getJsonStr() {
        String fileName = "json2.txt";
        String res="";
        try{
            InputStream in = getResources().getAssets().open(fileName);

            int length = in.available();
            byte [] buffer = new byte[length];

            in.read(buffer);
            in.close();
            res = EncodingUtils.getString(buffer, "UTF-8");

        }catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contract, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
