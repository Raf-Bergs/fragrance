package com.limmy.fragranceApp.Fragrance.brand;

import com.limmy.fragranceApp.Fragrance.Mappers.BrandMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.limmy.fragranceApp.Fragrance.util.NameNormalizer.normalize;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public BrandDTO getBrandById(int id) throws BrandNotFoundException {
        return brandRepository.findById(id)
                .map(BrandMapper::toBrandDTO)
                .orElseThrow(BrandNotFoundException::new);
    }

    public int createBrand(CreateBrandDTO createBrandDTO) {
        if (brandRepository.findByNameIgnoreCase(createBrandDTO.name()).isPresent()) {
            throw new BrandAlreadyExistsException();
        }
        Brand newBrand = new Brand(
                normalize(createBrandDTO.name()),
                normalize(createBrandDTO.country()),
                createBrandDTO.website(),
                createBrandDTO.yearFounded(),
                createBrandDTO.isNiche(),
                createBrandDTO.description(),
                createBrandDTO.logoUrl()
        );
        brandRepository.save(newBrand);
        return newBrand.getId();
    }
}
