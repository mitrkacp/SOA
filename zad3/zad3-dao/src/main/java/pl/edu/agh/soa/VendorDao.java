package pl.edu.agh.soa;

import pl.edu.agh.soa.model.Category;
import pl.edu.agh.soa.model.Product;
import pl.edu.agh.soa.model.Vendor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class VendorDao {

    @PersistenceContext(unitName = "vnd")
    EntityManager entityManager;

    public static VendorEntity vendorToEntity(Vendor vendor) {
        VendorEntity vendorEntity = new VendorEntity();

        vendorEntity.setFirstName(vendor.getFirstName());
        vendorEntity.setLastName(vendor.getLastName());
        vendorEntity.setVendorId(vendor.getId());
        vendorEntity.setNickname(vendor.getNickname());
        vendorEntity.setCountry(vendor.getCountry());
        vendorEntity.setDepositEntity(DepositDao.depositToEntity(vendor.getDeposit()));

        List<ProductEntity> productsEntities = vendor.getProducts()
                .stream()
                .map(ProductDao::productToEntity)
                .collect(Collectors.toList());
        vendorEntity.setProductsEntities(productsEntities);

        List<CategoryEntity> categoryEntities = vendor.getCategories()
                .stream()
                .map(CategoryDao::categoryToEntity)
                .collect(Collectors.toList());
        vendorEntity.setCategories(categoryEntities);


        return vendorEntity;
    }

    public static Vendor entityToVendor(VendorEntity vendorEntity){
        Vendor vendor = new Vendor();
        vendor.setFirstName(vendorEntity.getFirstName());
        vendor.setLastName(vendorEntity.getLastName());
        vendor.setNickname(vendorEntity.getNickname());
        vendor.setId(vendorEntity.getVendorId());
        vendor.setCountry(vendorEntity.getCountry());
        vendor.setDeposit(DepositDao.entityToDeposit(vendorEntity.getDepositEntity()));


        List<Product> products = vendorEntity.getProductsEntities()
                .stream()
                .map(ProductDao::entityToProduct)
                .collect(Collectors.toList());
        vendor.setProducts(products);

        List<Category> categories = vendorEntity.getCategories()
                .stream()
                .map(CategoryDao::entityToCategory)
                .collect(Collectors.toList());
        vendor.setCategories(categories);

        return vendor;
    }

    public void save(Vendor vendor){
        entityManager.persist(VendorDao.vendorToEntity(vendor));
    }

    public List<Vendor> getAllVendors() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<VendorEntity> query = criteriaBuilder.createQuery(VendorEntity.class);
        Root<VendorEntity> vendorEntityRoot = query.from(VendorEntity.class);
        query.select(vendorEntityRoot);

        return entityManager
                .createQuery(query)
                .getResultList()
                .stream()
                .map(VendorDao::entityToVendor)
                .collect(Collectors.toList());
    }

    public Vendor findVendorById(int id) throws Exception {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<VendorEntity> query = criteriaBuilder.createQuery(VendorEntity.class);
        Root<VendorEntity> vendorEntityRoot = query.from(VendorEntity.class);
        query.select(vendorEntityRoot).where(criteriaBuilder.equal(vendorEntityRoot.get("vendorId"), Integer.toString(id)));

        return entityToVendor(entityManager.createQuery(query).getSingleResult());
    }

    public void update(Vendor vendor) throws Exception {
        VendorEntity vendorEntity = findVendorByIdEntity(vendor.getId());
//        vendorEntity.setFirstName(vendor.getFirstName());
//        vendorEntity.setLastName(vendor.getLastName());
        vendorEntity.setNickname(vendor.getNickname());


        entityManager.merge(vendorEntity);
    }

    public VendorEntity findVendorByIdEntity(int id) throws Exception {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<VendorEntity> query = criteriaBuilder.createQuery(VendorEntity.class);
        Root<VendorEntity> vendorEntityRoot= query.from(VendorEntity.class);
        query.select(vendorEntityRoot).where(criteriaBuilder.equal(vendorEntityRoot.get("vendorId"), id));

        return entityManager.createQuery(query).getResultList().get(0);
    }
}
