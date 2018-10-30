package cn.edu.pku.guohongyu.weather;

import android.app.Activity;
import android.app.Person;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.pku.guohongyu.app.MyApplication;
import cn.edu.pku.guohongyu.bean.City;

public class SelectCity extends Activity implements View.OnClickListener {
    private ListView myCityView;

    private ImageView mBackBtn;
    private List<String>cityCodes =new ArrayList<String>();
    private List<City> cityList;
    private ArrayList<City> filterDateList;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_city);

        mBackBtn = (ImageView) findViewById(R.id.title_back);
        mBackBtn.setOnClickListener(this);
        /*mList=(ListView)this.findViewById(R.id.title_list);*/

        initViews();
    }
    public void  onClick(View v){
        switch (v.getId()){
            case R.id.title_back:
                Intent i =new Intent();
                i.putExtra("cityCode","101160101");
                setResult(RESULT_OK,i);
            finish();
            break;
            default:
                break ;
        }
    }
/*
  public class Myadapter extends ArrayList<City>{
        public Myadapter(Context context,int resource,List<City> items){
            super(context,resource,items);
        }
        public View getView(int position,View v,ViewGroup parent){
            if (v==null){
                LayoutInflater inflater =LayoutInflater.from((getContext()));
            }
        }
*/



    private void  initViews(){
        myCityView=(ListView)findViewById(R.id.title_list);
        List<String> cityName = new ArrayList<String>();
        List<City> citis =MyApplication.getInstance().getCityList();
        for (int i=0;i<citis.size();i++) {
            cityName.add(citis.get(i).getCity());
            cityCodes.add(citis.get(i).getNumber());
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cityName);

        mBackBtn=(ImageView)findViewById(R.id.title_back);
        mBackBtn.setOnClickListener(this);
        myCityView.setAdapter(adapter);
        myCityView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent ite = new Intent();
                ite.putExtra("cityCode",cityCodes.get(i));
                setResult(RESULT_OK,ite);
                finish();
            }
        });


       /* ClearEditText mClearEditText = (ClearEditText) findViewById(R.id.search_city);


        MyApplication myApplication =(MyApplication) getApplication();
        cityList = myApplication.getCityList();

        for (City city: cityList){
            filterDateList.add(city);
        }
        myadapter = new Myadapter(SelectCity.this,cityList);
        mList.setAdapter(myadapter);*/
//        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                City city =filterDateList.get(position);
//                Intent a =new Intent();
//                a.putExtra("cityCode",city.getNumber());
//                setResult(RESULT_OK,a);
//                finish();
//            }
//        });
    }



}
