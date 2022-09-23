using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EStore.Models
{
    public class Product
    {
        public string Id { get; set; }
        public string ProductCode { get; set; }
        public string Name { get; set; }
        public string Barcode { get; set; }
        public string Description { get; set; }
        public string ProductImageUrl { get; set; }
        public int CurrencyId { get; set; }
        public double Price { get; set; }
    }
}
