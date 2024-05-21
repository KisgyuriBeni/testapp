<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use App\Models\Product;

class Selection extends Model
{
    use HasFactory;

    protected $fillable = [
        "id", "selection_name"
    ];

    public function products(){
        return $this->hasMany(Product::class, "selection_id", "id");
    }

    public $timestamps = false;
}
