package com.example.dynamic.contract;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.dynamic.entity.ContractFieldRopChild;
import com.example.dynamic.entity.ContractFieldRopResult;
import com.example.dynamic.view.checkbox.decorate.CheckBoxDecorate1;
import com.example.dynamic.view.checkbox.checkbox.MyCheckBox1;
import com.example.dynamic.view.edittext.CreateEditText;
import com.example.dynamic.view.radiobutton.radiobutton.MyRadioButton1;
import com.example.dynamic.view.radiobutton.decorate.RadioButtonDecorate1;
import com.example.sg.myproject.R;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ContractActivityFragment extends Fragment {

    List<ContractFieldRopResult> lists;
    LinearLayout layout;

    public List<ContractFieldRopResult> getLists() {
        return lists;
    }

    public ContractActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contract, container, false);

        lists = (List<ContractFieldRopResult>) getArguments().get("list");
        layout = (LinearLayout) view.findViewById(R.id.layout);

        for (ContractFieldRopResult contractFieldRopResult : lists) {

            LinearLayout linearLayout = new LinearLayout(getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(130, 50);
            LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            linearLayout.setLayoutParams(layoutParams1);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            TextView textView = new TextView(getActivity());
            textView.setText(contractFieldRopResult.getName() + ":");
            linearLayout.addView(textView);
            if (contractFieldRopResult.getField_type().equals("input")) {//如果是输入框

                EditText editText = CreateEditText.getEditText(getActivity(), 1);
//                Toast.makeText(getActivity(),editText.getId() + "",Toast.LENGTH_SHORT).show();
                //editText.setLayoutParams(layoutParams);
//                editText = new EditTextDecorate1(editText.getCurrentContext(), editText);
//                Toast.makeText(getActivity(),editText.getId() + "",Toast.LENGTH_SHORT).show();
                //editText.setSingleLine(true);
                editText.setText(contractFieldRopResult.getResult());
                editText.addTextChangedListener(getTextWatcher(lists.indexOf(contractFieldRopResult), contractFieldRopResult));
                linearLayout.addView(editText);
            } else if (contractFieldRopResult.getField_type().equals("checkbox")) {
                List<ContractFieldRopChild> contractFieldRopChilds = contractFieldRopResult.getChildren();
                LinearLayout linearLayout2 = new LinearLayout(getActivity());
                linearLayout2.setOrientation(LinearLayout.HORIZONTAL);
                if (contractFieldRopChilds != null && contractFieldRopChilds.size() > 0) {
                    for (ContractFieldRopChild contractFieldRopChild : contractFieldRopChilds) {
                        if (contractFieldRopChild.getField_type().equals("checkbox")) {
                            CheckBox checkBox = new MyCheckBox1(getActivity());
                            checkBox = new CheckBoxDecorate1(checkBox).getCustomCheckBox();
                            checkBox.setId((int)contractFieldRopChild.getId());
                            checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                                if (isChecked) {
                                    contractFieldRopChild.setResult("1");
                                } else {
                                    contractFieldRopChild.setResult("0");
                                }
                                contractFieldRopChilds.set(contractFieldRopChilds.indexOf(contractFieldRopChild), contractFieldRopChild);
                                contractFieldRopResult.setChildren(contractFieldRopChilds);
                                lists.set(lists.indexOf(contractFieldRopResult), contractFieldRopResult);
                            });
                            if (contractFieldRopChild.getResult() != null && contractFieldRopChild.getResult().equals("1")) {
                                checkBox.setChecked(true);
                            }
                            checkBox.setText(contractFieldRopChild.getName());
                            linearLayout2.addView(checkBox);
                        }else if (contractFieldRopChild.getField_type().equals("input")) {
                            linearLayout.addView(linearLayout2);
                            EditText editText = CreateEditText.getEditText(getActivity(), 2);
                           // editText.setText(contractFieldRopChild.getResult());
                            editText.addTextChangedListener(getTextWatcher2(contractFieldRopChilds.indexOf(contractFieldRopChild), contractFieldRopResult, contractFieldRopChilds, contractFieldRopChild));
                            linearLayout.addView(editText);
                        }
                    }
                }
            }else if (contractFieldRopResult.getField_type().equals("radio")) {
                List<ContractFieldRopChild> contractFieldRopChilds = contractFieldRopResult.getChildren();
                if (contractFieldRopChilds != null && contractFieldRopChilds.size() > 0) {
                    RadioGroup radioGroup = new RadioGroup(getActivity());
                    radioGroup.setOrientation(RadioGroup.HORIZONTAL);
                    for (ContractFieldRopChild contractFieldRopChild : contractFieldRopChilds) {
                        if (contractFieldRopChild.getField_type().equals("radio")) {
                            RadioButton radioButton = new RadioButtonDecorate1(new MyRadioButton1(getActivity())).getCustomRadioButton();
                            radioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
                                if (isChecked) {
                                    for (int i = 0; i < contractFieldRopChilds.size(); i++) {
                                        ContractFieldRopChild contractFieldRopChild1 = contractFieldRopChilds.get(i);
                                        if (contractFieldRopChild1.getResult() != null && contractFieldRopChild1.getResult().equals("1")) {
                                            if (i != contractFieldRopChilds.indexOf(contractFieldRopChild)) {
                                                contractFieldRopChild1.setResult("0");
                                                contractFieldRopChilds.set(i, contractFieldRopChild1);
                                                contractFieldRopResult.setChildren(contractFieldRopChilds);
                                                lists.set(lists.indexOf(contractFieldRopResult), contractFieldRopResult);
                                                ((RadioButton) radioGroup.getChildAt(i)).setChecked(false);
                                            }
                                        }
                                    }
                                    contractFieldRopChild.setResult("1");
                                    radioButton.setChecked(true);
                                } else {
                                    contractFieldRopChild.setResult("0");
                                }
                                contractFieldRopChilds.set(contractFieldRopChilds.indexOf(contractFieldRopChild), contractFieldRopChild);
                                contractFieldRopResult.setChildren(contractFieldRopChilds);
                                lists.set(lists.indexOf(contractFieldRopResult), contractFieldRopResult);
                            });
                            if (contractFieldRopChild.getResult() != null && contractFieldRopChild.getResult().equals("1")) {
                                radioButton.setChecked(true);
                            } else {
                                radioButton.setChecked(false);
                            }
                            radioButton.setText(contractFieldRopChild.getName());
                            radioButton.setLayoutParams(layoutParams1);
                            radioGroup.addView(radioButton);
                        } else if (contractFieldRopChild.getField_type().equals("input")) {
                            linearLayout.addView(radioGroup);
                            EditText editText = CreateEditText.getEditText(getActivity(), 2);
                            /*editText.setLayoutParams(layoutParams);
                            editText.setSingleLine(true);*/
                            editText.setText(contractFieldRopChild.getResult());
                            editText.addTextChangedListener(getTextWatcher2(contractFieldRopChilds.indexOf(contractFieldRopChild), contractFieldRopResult, contractFieldRopChilds, contractFieldRopChild));
                            linearLayout.addView(editText);
                        }
                    }
                }
            }
            layout.addView(linearLayout);
//            Toast.makeText(getActivity(), contractFieldRopResult.getName(), Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    private TextWatcher getTextWatcher(int i,ContractFieldRopResult contractFieldRopResult) {
        TextWatcher watcher = new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                contractFieldRopResult.setResult(s.toString());
                lists.set(i, contractFieldRopResult);
            }
        };
        return watcher;
    }

    private TextWatcher getTextWatcher2(int i,ContractFieldRopResult contractFieldRopResult,List<ContractFieldRopChild> contractFieldRopChilds,ContractFieldRopChild contractFieldRopChild) {
        TextWatcher watcher = new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                contractFieldRopChild.setResult(s.toString());
                contractFieldRopChilds.set(i, contractFieldRopChild);
                contractFieldRopResult.setChildren(contractFieldRopChilds);
            }
        };
        return watcher;
    }
}
