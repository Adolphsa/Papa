package com.lucas.architecture.data.repository;

import com.lucas.architecture.domain.manager.NetState;

/**
 * 专用于数据层返回结果给 domain 层或 ViewModel 用
 * Created by lucas
 * Date: 2020/9/25 12:04
 */
public class DataResult<T> {

    private T mT;
    private Result<T> mResult;
    private NetState mNetState;

    public DataResult() {
    }

    public DataResult(Result<T> result) {
        mResult = result;
    }

    public T getResult() {
        return mT;
    }

    public NetState getNetState() {
        return mNetState;
    }

    public void setResult(T t, NetState netState) {
        if (mResult == null) {
            throw new NullPointerException("Need to instantiate the Result<T> first ...");
        }
        if (t == null) {
            throw new NullPointerException("Need to instantiate the T first ...");
        }
        if (netState == null) {
            throw new NullPointerException("Need to instantiate the NetState first ...");
        }

        mT = t;
        mNetState = netState;
        mResult.onResult(t, netState);
    }

    public void onObserve(Result<T> result) {
        if (result == null) {
            throw new NullPointerException("Need to instantiate the Result<T> first ...");
        }
        if (mResult == null) {
            mResult = result;
        }
    }

    public interface Result<T> {
        void onResult(T t, NetState netState);
    }

}
