<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use App\Models\Employee;

class Position extends Model
{
    use HasFactory;

    protected $fillable = [
        "id", "position_name"
    ];

    public function employees(){
        return $this->hasMany(Employee::class, "position_id", "id");
    }
    
    public $timestamps = false;
}
