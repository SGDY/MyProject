package com.example.dynamic.contract;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.dynamic.entity.ContractFieldRopChild;
import com.example.dynamic.entity.ContractFieldRopResult;
import com.example.dynamic.util.HttpUtil;
import com.example.sg.myproject.R;

import org.apache.http.NameValuePair;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ContractFragment extends Fragment {

    List<ContractFieldRopResult> lists;
    LinearLayout layout;

    public static ContractFragment newInstance(Bundle bundle) {
        ContractFragment fragment = new ContractFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    public ContractFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contract2, container, false);
        layout = (LinearLayout) view.findViewById(R.id.layout);

        if (getArguments() != null) {
            lists = (List<ContractFieldRopResult>) getArguments().get("list");
        }
        for (ContractFieldRopResult contractFieldRopResult : lists) {

            LinearLayout linearLayout = new LinearLayout(getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 50);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            if (contractFieldRopResult.getField_type().equals("input")) {//如果是输入框
                TextView textView = new TextView(getActivity());
                textView.setText(contractFieldRopResult.getName() + ":" + contractFieldRopResult.getResult());
                linearLayout.addView(textView);
            } else if (contractFieldRopResult.getField_type().equals("checkbox")) {
                TextView textView = new TextView(getActivity());
                textView.setText(contractFieldRopResult.getName());
                linearLayout.addView(textView);
                List<ContractFieldRopChild> contractFieldRopChilds = contractFieldRopResult.getChildren();
                if (contractFieldRopChilds != null && contractFieldRopChilds.size() > 0) {
                    for (ContractFieldRopChild contractFieldRopChild : contractFieldRopChilds) {
                        if (contractFieldRopChild.getField_type().equals("checkbox")) {
                            CheckBox checkBox = new CheckBox(getActivity());
                            checkBox.setClickable(false);
                            if (contractFieldRopChild.getResult() != null && contractFieldRopChild.getResult().equals("1")) {
                                checkBox.setChecked(true);
                            }
                            checkBox.setText(contractFieldRopChild.getField_value());
                            linearLayout.addView(checkBox);
                        } else if (contractFieldRopChild.getField_type().equals("input")) {
                            EditText editText = new EditText(getActivity());
                            editText.setLayoutParams(layoutParams);
                            editText.setSingleLine(true);
                            editText.setText(contractFieldRopChild.getResult());
                            editText.setEnabled(false);
                            linearLayout.addView(editText);
                        }
                    }
                }
            }else if (contractFieldRopResult.getField_type().equals("radio")) {
                TextView textView = new TextView(getActivity());
                textView.setText(contractFieldRopResult.getName());
                linearLayout.addView(textView);
                List<ContractFieldRopChild> contractFieldRopChilds = contractFieldRopResult.getChildren();
                RadioGroup radioGroup = new RadioGroup(getActivity());
                radioGroup.setOrientation(RadioGroup.HORIZONTAL);
                if (contractFieldRopChilds != null && contractFieldRopChilds.size() > 0) {
                    for (ContractFieldRopChild contractFieldRopChild : contractFieldRopChilds) {
                        if (contractFieldRopChild.getField_type().equals("radio")) {
                            RadioButton radioButton = new RadioButton(getActivity());
                            radioButton.setClickable(false);
                            if (contractFieldRopChild.getResult() != null && contractFieldRopChild.getResult().equals("1")) {
                                radioButton.setChecked(true);
                            }
                            radioButton.setText(contractFieldRopChild.getField_value());
                            radioGroup.addView(radioButton);
                        } else if (contractFieldRopChild.getField_type().equals("input")) {
                            linearLayout.addView(radioGroup);
                            EditText editText = new EditText(getActivity());
                            editText.setLayoutParams(layoutParams);
                            editText.setSingleLine(true);
                            editText.setText(contractFieldRopChild.getResult());
                            editText.setEnabled(false);
                            linearLayout.addView(editText);
                        }
                    }
                }
            }
            layout.addView(linearLayout);
        }

        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Thread thread = new Thread(networkTask);
            thread.start();
        });
        return view;
    }

    /**
     * 加载数据
     */
    private void loadData() {
        String str = null;
        try {
            str = "http://192.168.40.174:8080/app/service?v=1.0&appKey=00001&format=json&method=incito.contract.contractField.saveOrUpdate&type=add&orderId=118";
            StringEntity se = new StringEntity(getJsonStr(),"UTF-8");
            HttpUtil.postResult(str, se);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

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

    private String getJsonStr() {
        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        try {
            for (ContractFieldRopResult contractFieldRopResult : lists) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", contractFieldRopResult.getId());
                jsonObject.put("name", contractFieldRopResult.getName());
                jsonObject.put("field_value", contractFieldRopResult.getField_value());
                jsonObject.put("field_type", contractFieldRopResult.getField_type());
                jsonObject.put("orderby", contractFieldRopResult.getOrderby());
                jsonObject.put("result", contractFieldRopResult.getResult() == null ? 0 : contractFieldRopResult.getResult());
                List<ContractFieldRopChild> contractFieldRopChildren = contractFieldRopResult.getChildren();
                JSONArray jsonArray = new JSONArray();
                if (contractFieldRopChildren != null && contractFieldRopChildren.size() > 0) {
                    for (ContractFieldRopChild contractFieldRopChild : contractFieldRopChildren) {
                        JSONObject jsonObject1 = new JSONObject();
                        jsonObject1.put("id", contractFieldRopChild.getId());
                        jsonObject1.put("name", contractFieldRopChild.getName());
                        jsonObject1.put("field_value", contractFieldRopChild.getField_value());
                        jsonObject1.put("field_type", contractFieldRopChild.getField_type());
                        jsonObject1.put("orderby", contractFieldRopChild.getOrderby());
                        jsonObject1.put("result", contractFieldRopChild.getResult() == null ? 0 : contractFieldRopChild.getResult());
                        jsonArray.put(jsonObject1);
                    }
                }
                jsonObject.put("children", jsonArray);
                array.put(jsonObject);
            }
            object.put("contractFieldRopList", array);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object.toString();
    }

}
