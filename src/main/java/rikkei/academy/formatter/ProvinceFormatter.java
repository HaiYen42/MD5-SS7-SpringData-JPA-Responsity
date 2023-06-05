package rikkei.academy.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import rikkei.academy.model.Province;
import rikkei.academy.service.province.IProvinceService;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
//@Component để Class ProvinceFormatter được tự động Scan
//  class ProvinceFormatter---> Dùng để Convert dữ liệu từ String --> Long
public class ProvinceFormatter implements Formatter <Province>{

    private IProvinceService provinceService;
    public ProvinceFormatter(IProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Autowired

    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        Optional<Province> province = provinceService.findById(Long.valueOf(text));
        return province.orElse(null);
    }

    @Override
    public String print(Province object, Locale locale) {
        return null;
    }
}
