package tw.com.rk62pt.jersey.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.*;

import tw.com.rk62pt.jersey.models.ShowModel;
import tw.com.rk62pt.jersey.models.vo.ShowVO;

public class ShowModel{

	public List<ShowVO> list() throws IOException{
		Gson gson = new Gson();
		List<ShowVO> voList = new ArrayList<ShowVO>();
		InputStream is = new URL("http://cloud.culture.tw/frontsite/trans/SearchShowAction.do?method=doFindTypeJ&category=6").openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      //String jsonText = readAll(rd);
	      StringBuilder sb = new StringBuilder();
	      int cp;
	      while ((cp = rd.read()) != -1) {
	        sb.append((char) cp);
	      }
	      JsonParser parser = new JsonParser();
	      JsonArray jArray = parser.parse(sb.toString()).getAsJsonArray();
	      //System.out.println(sb.toString());
	      Type listType = new TypeToken<ArrayList<ShowVO>>() {
          }.getType();
	      //voList = gson.fromJson(sb.toString(), listType);
          for(JsonElement obj : jArray )
          {
        	  //System.out.println(obj);
        	  ShowVO cse = gson.fromJson( obj , ShowVO.class);
        	  voList.add(cse);
          }
	    } finally {
	        is.close();
	     }
	    //System.out.println(json);
	    System.out.println("here");
		return voList;
	}
	
	public List<ShowVO> listByCity(String keyword) throws IOException, ParseException{
		Gson gson = new Gson();
		List<ShowVO> voList = new ArrayList<ShowVO>();
		List<ShowVO> newList = new ArrayList<ShowVO>();
		InputStream is = new URL("http://cloud.culture.tw/frontsite/trans/SearchShowAction.do?method=doFindTypeJ&category=6").openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      //String jsonText = readAll(rd);
	      StringBuilder sb = new StringBuilder();
	      int cp;
	      while ((cp = rd.read()) != -1) {
	        sb.append((char) cp);
	      }
	      JsonParser parser = new JsonParser();
	      JsonArray jArray = parser.parse(sb.toString()).getAsJsonArray();
	      //System.out.println(sb.toString());
	      Type listType = new TypeToken<ArrayList<ShowVO>>() {
          }.getType();
	      //voList = gson.fromJson(sb.toString(), listType);
          for(JsonElement obj : jArray )
          {
        	  //System.out.println(obj);
        	  ShowVO cse = gson.fromJson( obj , ShowVO.class);
        	  voList.add(cse);
          }
          newList = voList.stream()
        		  .filter(v -> ((v.getShowInfo()[0].getLocation()).length()<3?"":v.getShowInfo()[0].getLocation().substring(0, 3)).equals(keyword) ).collect(Collectors.toList());
          System.out.println(keyword);
	    } finally {
	        is.close();
	     }
	    //System.out.println(json);
	    System.out.println("here");
		return newList;
	}
}
