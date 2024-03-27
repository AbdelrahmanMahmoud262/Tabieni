package com.tabieni.domain.usecase

sealed class UseCaseException(cause: Throwable) : Throwable(cause) {

    class MemorizeException(cause: Throwable) : UseCaseException(cause)
    class RevisionException(cause: Throwable) : UseCaseException(cause)
    class ConnectionException(cause: Throwable) : UseCaseException(cause)

    class SurahException(cause: Throwable) : UseCaseException(cause)


    class UnknownException(cause: Throwable) : UseCaseException(cause)


    companion object {

        fun createFromThrowable(throwable: Throwable): UseCaseException {
            return if (throwable is UseCaseException) throwable else UnknownException(throwable)
        }
    }
}