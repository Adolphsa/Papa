package com.lucas.architecture.domain.usecase;

/**
 * Interface for schedulers, see {@link UseCaseThreadPoolScheduler}.
 * Created by lucas
 * Date: 2020/9/25 14:26
 */
public interface UseCaseScheduler {

    void execute(Runnable runnable);

    <V extends UseCase.ResponseValue> void notifyResponse(final V response,
                                                          final UseCase.UseCaseCallback<V> useCaseCallback);

    <V extends UseCase.ResponseValue> void onError(
            final UseCase.UseCaseCallback<V> useCaseCallback);
}
