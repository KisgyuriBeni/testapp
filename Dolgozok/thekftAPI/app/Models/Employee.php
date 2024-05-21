<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use App\Models\Position;
use App\Models\Sale;

class Employee extends Model
{
    use HasFactory;

    protected $fillable = [
        "id", "employee_name", "phone_number", "hire_date", "salary", "position_id"
    ];

    public function positions(){
        return $this->belongsTo(Position::class, "position_id", "id");
    }
    public function sales(){
        return $this->hasMany(Sale::class, "employee_id", "id");
    }

    public $timestamps = false;
}
