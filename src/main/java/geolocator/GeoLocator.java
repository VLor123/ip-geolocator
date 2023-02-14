package geolocator;

import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.gson.GsonDecoder;

public interface GeoLocator {

    @RequestLine("GET")
    GeoLocation getGeoLocation();

    @RequestLine("GET /{ipOrHostName}")
    GeoLocation getGeoLocation(@Param("ipOrHostName") String ipOrHostName);

    static GeoLocator newInstance() {
        return Feign.builder()
            .decoder(new GsonDecoder())
            .target(GeoLocator.class, "http://ip-api.com/json/");
    }

}
