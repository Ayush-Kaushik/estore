using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EStore.Models
{
    public interface IProductRepository
    {
        Product GetProduct(string id);
        Product Add(Product product);
        Product Delete(string id);
        IEnumerable<Product> GetAllProducts();
    }
}
