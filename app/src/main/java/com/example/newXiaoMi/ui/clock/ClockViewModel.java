package com.example.newXiaoMi.ui.clock;

import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newXiaoMi.util.TranNum;

public class ClockViewModel extends ViewModel {
    MutableLiveData<Handler> handlerMutableLiveData;
    MutableLiveData<Handler> handlerMutableLiveDataD;
    MutableLiveData<Boolean> needstay;

    public MutableLiveData<Handler> getHandlerMutableLiveDataD() {
        return handlerMutableLiveDataD;
    }

    public ClockViewModel() {
        if(needstay ==null){
            needstay = new MutableLiveData<>();
            needstay.postValue(false);
        };
        if(handlerMutableLiveData ==null){
            handlerMutableLiveData = new MutableLiveData<>();
        }

        if(handlerMutableLiveDataD ==null){
            handlerMutableLiveDataD = new MutableLiveData<>();
        }
    }

    public MutableLiveData<Handler> getHandlerMutableLiveData() {
        return handlerMutableLiveData;
    }

    public MutableLiveData<String> getTimeShow() {
        if(timeShow==null){
            timeShow = new MutableLiveData<>();
            timeShow.setValue( TranNum.secToTime(0));
        }
        return timeShow;
    }


    public void setTimeShow(int num) {
        timeShow.postValue(TranNum.secToTime(num));

    }


   public MutableLiveData<String> timeShow;


    public void countTime(){
        if(timeShow==null){
        timeShow = new MutableLiveData<>();

        timeShow.setValue( TranNum.secToTime(0));
    }
        Log.i("计科1701_asp",timeShow.getValue());
//        Log.i("计科1701_asp",TranNum.formatTurnSecond(timeShow.getValue())+1+"");


    timeShow.postValue(TranNum.secToTime(TranNum.formatTurnSecond(
            timeShow.getValue())+1));
    }

    public MutableLiveData<Boolean> getNeedstay() {
        return needstay;
    }
}
