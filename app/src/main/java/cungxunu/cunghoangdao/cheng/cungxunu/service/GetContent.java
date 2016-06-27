package cungxunu.cunghoangdao.cheng.cungxunu.service;

import android.content.Context;
import android.os.AsyncTask;

import cungxunu.cunghoangdao.cheng.cungxunu.interfaces.OnReturnContent;

/**
 * Created by Welcome on 5/13/2016.
 */
public class GetContent extends AsyncTask<String, String, String> {
    public OnReturnContent onReturnContent;
    private Context context;
    private String url;
    private ApiService.ApiRequestType requestType;
    private String parameters;

    public GetContent(OnReturnContent onReturnContent, Context context,
                      String url, ApiService.ApiRequestType requestType, String parameters) {
        this.onReturnContent = onReturnContent;
        this.context = context;
        this.url = url;
        this.requestType = requestType;
        this.parameters = parameters;
    }

    @Override
    protected String doInBackground(String... params) {
        return ApiService.makeHttpRequest(context,url,requestType,parameters);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        onReturnContent.onReturnContent(s);
    }
}
