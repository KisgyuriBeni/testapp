<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use App\Models\Sale;

class Customer extends Model
{
    use HasFactory;

    protected $fillable =[
        "id", "customer_name", "phone_number"
    ];

    public function sales(){
        return $this->hasMany(Sale::class, "customer_id", "id");
    }

    public $timestamps = false;

}
