<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use App\Models\Employee;
use App\Models\Product;
use App\Models\Customer;

class Sale extends Model
{
    use HasFactory;

    protected $fillable = [
        "id", "sale_date", "paid", "employee_id", "product_id", "customer_id"
    ];

    public function employees(){
        return $this->belongsTo(Employee::class, "employee_id", "id");
    }

    public function products(){
        return $this->belongsTo(Product::class, "product_id", "id");
    }

    public function customers(){
        return $this->belongsTo(Customer::class, "customer_id", "id");
    }
    public $timestamps = false;
}
