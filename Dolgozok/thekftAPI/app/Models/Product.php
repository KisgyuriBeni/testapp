<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use App\Models\Selection;
use App\Models\Sale;

class Product extends Model
{
    use HasFactory;

    protected $flladble=[
        "id", "product_name", "amount", "price", "selection_id", "purchaser"
    ];

    public function selections(){
        return $this->belongsTo(Selection::class, "selection_id", "id");
    }
    public function sales(){
        return $this->hasMany(Sale::class, "product_id", "id");
    }

    public $timestamps = false;
}
