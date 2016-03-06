package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import web.domain.Location;
import web.service.LocationService;

import java.util.List;

/**
 * Created by Pavel on 06.03.2016.
 */
@Controller
public class LocationController {

    @Autowired
    LocationService locationService;

    @RequestMapping(value = "/getLocs", method = RequestMethod.POST)
    public @ResponseBody
    List<Location> getLocations(@RequestParam("startNumber") String startNumber) {
        List<Location> locs = locationService.findAll();
        if(locs.size() > 0){
            return locs;
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody
    String main() {
        return "location";
    }
}
