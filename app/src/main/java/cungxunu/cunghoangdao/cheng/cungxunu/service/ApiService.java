package cungxunu.cunghoangdao.cheng.cungxunu.service;


import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

public class ApiService {
    private static String TAG = "ApiService";
    public enum ApiRequestType {
        TYPE_POST,
        TYPE_PUT,
        TYPE_DELETE,
        TYPE_GET
    }

    public static String makeHttpRequest(Context context, String targetUrl,
                                                      ApiRequestType typeRequest, String params) {
        URL url;
        HttpURLConnection httpURLConnection = null;
        String content = null;
        StringBuilder response = null;
        try {
            url = new URL(targetUrl);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(true);

            switch (typeRequest) {
                case TYPE_POST:
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    break;
                case TYPE_GET:
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setDoOutput(false);
                    break;
                case TYPE_PUT:
                    httpURLConnection.setRequestMethod("PUT");
                    httpURLConnection.setDoOutput(true);
                    break;
                default:
                    httpURLConnection.setRequestMethod("DELETE");
                    httpURLConnection.setDoOutput(false);
                    break;
            }
            httpURLConnection.setReadTimeout(15000); //15s
            httpURLConnection.setConnectTimeout(15000); //15s
            httpURLConnection.setUseCaches(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            Log.d(TAG, "makeHttpRequest: "+httpURLConnection.getURL());
            int responseCode = httpURLConnection.getResponseCode();
            System.out.println(responseCode);
            String location = httpURLConnection.getHeaderField("Location");
            if ((params != null) && (!params.equals(""))) {
                DataOutputStream os = new DataOutputStream(httpURLConnection.getOutputStream());
                os.writeBytes(params);
                os.flush();
                os.close();
            }
            InputStream is = httpURLConnection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
            response = new StringBuilder();
            while ((content = rd.readLine()) != null) {
                response.append(content);
            }
            rd.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SocketTimeoutException e) {
            Log.d("SocketTimeoutException", "SocketTimeoutException: ");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return response.toString();
    }
}
