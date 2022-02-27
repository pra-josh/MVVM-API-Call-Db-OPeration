package com.pra.modernappmvvm.Data.api

class IErrorMessage {
    companion object {
        var CONTENT_NOT_MODIFIED = "Content not modified"
        var OTHER_EXCEPTION = "We could not complete your request"
        var SOMETHING_WRONG_ERROR = "Something went wrong!!\nPlease try again later."
        var IO_EXCEPTION = "Something went wrong!!\nPlease try again later."
        var INTERNAL_SERVER_ERROR = "Internal server error"
        var NO_INTERNET_CONNECTION = "No internet connection."
        var IO_EXCEPTION_CANCEL_API = "Something went wrong!!\nPlease try again later."
        var IO_EXCEPTION_OTHER_ERROR = "Something went wrong!!\nPlease try again later."
        var TIME_OUT_CONNECTION = "Connection timeout.\nPlease try again later."
        var CONNECTION_ERROR = "Could not connect to server\nPlease try again later."
        var PARSING_ERROR = "Parsing Error"
    }
}