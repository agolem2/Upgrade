package api;



import static org.junit.Assert.*;



import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import org.apache.http.client.methods.HttpGet;

import org.apache.http.client.methods.HttpUriRequest;

import org.apache.http.entity.ContentType;

import org.apache.http.impl.client.HttpClientBuilder;

import org.apache.http.util.EntityUtils;

import org.json.JSONArray;

import org.json.JSONException;

import org.json.JSONObject;

import org.junit.Test;



public class CarRentalResponse {



    @Test

    public void

    GetKayakCarRequest()

    throws ClientProtocolException, IOException, JSONException {

        // Given

        String jsonMimeType = "application/json";

        HttpUriRequest request = new HttpGet("https://pia.services.carrentals.com/api/v2/destinations?language=us&limit=1000&q=san");



        // When

        org.apache.http.HttpResponse response = HttpClientBuilder.create().build().execute(request);



        // Then

        String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();

        assertEquals(jsonMimeType, mimeType);



        String json = EntityUtils.toString(response.getEntity());

        System.out.println("Response String" + json);

 

        JSONObject jsobj = new JSONObject(json);

        System.out.println("Response Object" + jsobj);

        JSONArray array=jsobj.getJSONArray("destinations");

        System.out.println("Response Array" + array);

        //Here we get json array inside obj2 with key- destinations

        JSONArray array1=jsobj.getJSONArray("destinations");

        //Getting json objects inside array

        for(int i=0;i<array1.length();i++){

            JSONObject Destinations=array1.getJSONObject(i);

        //Getting Destinations and type of json objects inside array

        System.out.println("List Of Destinations : "+Destinations);

            System.out.println("List Of Destinations with apt_code : "+Destinations.getString("apt_code"));

        }



         }

       

    }

