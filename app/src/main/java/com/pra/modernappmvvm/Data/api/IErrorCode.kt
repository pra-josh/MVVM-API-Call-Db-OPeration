package com.pra.modernappmvvm.Data.api

class IErrorCode {

    companion object {
        var defaultErrorCode = 5001
        var notInternetConnErrorCode = 5002
        var ioExceptionCancelApiErrorCode = 5003
        var ioExceptionOtherErrorCode = 5004
        var socketTimeOutError = 5006
        var internalServerError = 5007
        var parsingError = 5008
        var connectionError = 5009
    }
}