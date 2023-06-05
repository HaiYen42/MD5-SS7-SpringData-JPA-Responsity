package rikkei.academy.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rikkei.academy.model.Province;

public interface IProvinceRepository extends PagingAndSortingRepository <Province, Long>{

}
