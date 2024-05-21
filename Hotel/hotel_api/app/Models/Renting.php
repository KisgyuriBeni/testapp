<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use App\Models\Renter;
use App\Models\Room;

class Renting extends Model
{
    use HasFactory;
    protected $fillable = [
        "id", "szoba_id", "foglalo_id", "foglalas_eleje", "foglalas_vege"
    ];
    public $timestamps = false;

    public function room() {
        return $this->belongsTo(Room::class, 'szoba_id', 'id');
    }
    
    public function renter() {
        return $this->belongsTo(Renter::class, 'foglalo_id', 'id');
    }
}
