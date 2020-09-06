package pl.edu.agh.soa;

import pl.edu.agh.soa.model.Category;
import pl.edu.agh.soa.model.Deposit;
import pl.edu.agh.soa.model.Vendor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class CategoryDao {

    @PersistenceContext(unitName = "vnd")
    EntityManager entityManager;

    public static CategoryEntity categoryToEntity(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setName(category.getName());
//        List<VendorEntity> vendorEntities = category.getVendorList()
//                .stream()
//                .map(VendorDao::vendorToEntity)
//                .collect(Collectors.toList());
//
//        categoryEntity.setVendorEntities(vendorEntities);

        return categoryEntity;
    }

    public static Category entityToCategory(CategoryEntity categoryEntity) {
        Category category = new Category();

        category.setName(categoryEntity.getName());
//        List<Vendor> vendors = categoryEntity.getVendorEntities()
//                .stream()
//                .map(VendorDao::entityToVendor)
//                .collect(Collectors.toList());
//
//        category.setVendorList(vendors);


        return category;
    }

    public void save(Category category) {
        entityManager.persist(CategoryDao.categoryToEntity(category));
    }
    public void add(CategoryEntity categoryEntity) {
        entityManager.persist(categoryEntity);
    }
}
