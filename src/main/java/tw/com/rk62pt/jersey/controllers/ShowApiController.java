package tw.com.rk62pt.jersey.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import tw.com.rk62pt.jersey.models.ShowModel;
import tw.com.rk62pt.jersey.models.ShowModel;
import tw.com.rk62pt.jersey.models.vo.ShowVO;


@Path("/show")
public class ShowApiController {
	@GET
	public List<ShowVO> list(){
		List<ShowVO> voList = new ArrayList<ShowVO>();
		
		try {
			ShowModel showService = new ShowModel();
			voList =showService.list();
			System.out.println(showService);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return voList;
	}
	
	//過濾展演資料 城市名稱
	@GET
    @Path("/{name}")
    public List<ShowVO> sayHello(@PathParam("name") String name) {
		List<ShowVO> voList = new ArrayList<ShowVO>();
		try {
			ShowModel showService = new ShowModel();
			voList =showService.listByCity(name);
			System.out.println(showService);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return voList;
    }
}
