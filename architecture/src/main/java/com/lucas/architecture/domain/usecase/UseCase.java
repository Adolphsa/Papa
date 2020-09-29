package com.lucas.architecture.domain.usecase;

/**
 *Use cases are the entry points to the domain layer.
 * @param <Q> the request type
 * @param <P> the response type
 *
 * Created by lucas
 * Date: 2020/9/25 14:27
 */
public abstract class UseCase<Q extends UseCase.RequestValues, P extends UseCase.ResponseValue>  {

    private Q mRequestValues;

    private UseCaseCallback<P> mUseCaseCallback;

    public Q getRequestValues() {
        return mRequestValues;
    }

    public void setRequestValues(Q requestValues) {
        mRequestValues = requestValues;
    }

    public UseCaseCallback<P> getUseCaseCallback() {
        return mUseCaseCallback;
    }

    public void setUseCaseCallback(UseCaseCallback<P> useCaseCallback) {
        mUseCaseCallback = useCaseCallback;
    }

    void run() {
        executeUseCase(mRequestValues);
    }

    protected abstract void executeUseCase(Q requestValues);

    /**
     * Data passed to a request.
     */
    public interface RequestValues {
    }

    /**
     * Data received from a request.
     */
    public interface ResponseValue {
    }

    public interface UseCaseCallback<R> {
        void onSuccess(R response);

        void onError();
    }

}
