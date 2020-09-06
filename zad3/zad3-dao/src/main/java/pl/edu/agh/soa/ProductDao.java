package pl.edu.agh.soa;

import pl.edu.agh.soa.model.Product;
import pl.edu.agh.soa.model.Vendor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class ProductDao {
    @PersistenceContext(unitName = "vnd")
    EntityManager entityManager;

    public static ProductEntity productToEntity(Product product){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setQuantity(product.getQuantity());
        productEntity.setEncoded64BaseImage(product.getEncoded64BaseImage());
        productEntity.setProductId(product.getPid());

        return productEntity;
    }

    public static Product entityToProduct(ProductEntity productEntity){
        Product product = new Product();
        product.setName(productEntity.getName());
        product.setPrice(productEntity.getPrice());
        product.setQuantity(productEntity.getQuantity());
        product.setEncoded64BaseImage(productEntity.getEncoded64BaseImage());
        product.setPid(productEntity.getProductId());

        return product;
    }

    public void save(Product product){
        entityManager.persist(ProductDao.productToEntity(product));
    }

    public void add(ProductEntity productEntity){
        entityManager.persist(productEntity);
    }

    public Product findProductById(int id) throws Exception {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> query = criteriaBuilder.createQuery(ProductEntity.class);
        Root<ProductEntity> productEntityRoot = query.from(ProductEntity.class);
        query.select(productEntityRoot).where(criteriaBuilder.equal(productEntityRoot.get("productId"), Integer.toString(id)));

        return entityToProduct(entityManager.createQuery(query).getSingleResult());
    }

    public ProductEntity findProductByIdEntity(int id) throws Exception {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> query = criteriaBuilder.createQuery(ProductEntity.class);
        Root<ProductEntity> productEntityRoot= query.from(ProductEntity.class);
        query.select(productEntityRoot).where(criteriaBuilder.equal(productEntityRoot.get("productId"), id));

        return entityManager.createQuery(query).getResultList().get(0);
    }

    public void update(Product product) throws Exception {
        ProductEntity productEntity = findProductByIdEntity(product.getPid());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setEncoded64BaseImage(product.getEncoded64BaseImage());
        productEntity.setQuantity(product.getQuantity());

        entityManager.merge(productEntity);
    }
}
