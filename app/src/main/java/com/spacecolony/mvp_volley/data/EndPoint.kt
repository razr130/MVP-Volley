package com.spacecolony.mvp_volley.data

object EndPoint {
    val url = "https://192.168.72.58:9082/"
    val auth = "Bearer h7L4dVX1HyFJllQ7kOnnS3_F5uJtmefqqFTC9BkIUdR_Ffb0ImLlf8WRi0mFNAEpgcONm7q0XGistHRwD_KHqBchKGDkM38swmX0Gz0EKjHhD8REgg0sv5JodXX1xjCPu1sH67ZmaQ8mZ2M9Kbu-yZKK3KcFDU2o7fjQiBmTMLYhNnZtWlZGZUaQ_Eyh9f363so3ENHtKRJXV_YnhcNBdr8JU9jRLeHmNtIlr1NfdJpEKKp0qzCLMfo4-pLyeO2QIJL1HuIvTYMTxJVQoQNeBH5ux44Vq6U1WS4eTyQxYy4p-aOTQb1CfPrwSQ0LC-39"
    fun pagestamp():String = url.plus("stamp/pagestamp")
}