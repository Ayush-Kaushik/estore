using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EStore.Models
{
    public class SQLProductRepository : IProductRepository
    {
        private readonly EStoreContext _eStoreContext;

        public SQLProductRepository(EStoreContext dbContext)
        {
            this._eStoreContext = dbContext;
        }

        public Product Add(Product product)
        {
            this._eStoreContext.Products.Add(product);
            this._eStoreContext.SaveChanges();
            return product;
        }

        public Product Delete(string id)
        {
            Product product = this._eStoreContext.Products.Find(id);
            this._eStoreContext.Products.Remove(product);
            return product;
        }

        public IEnumerable<Product> GetAllProducts()
        {
            return this._eStoreContext.Products;
        }

        public Product GetProduct(string id)
        {
            return this._eStoreContext.Products.Find(id);
        }

        public Product Update(Product productChanges)
        {
            var product = this._eStoreContext.Products.Attach(productChanges);
            product.State = EntityState.Modified;
            this._eStoreContext.SaveChanges();
            return productChanges;
        }
    }
}
