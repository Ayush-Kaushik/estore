using EStore.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EStore.Models
{
    public class EStoreContext : DbContext
    {
        public EStoreContext(DbContextOptions<EStoreContext> options) : base(options)
        {

        }

        public DbSet<Product> Products { get; set; }
    }
}
