<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use App\Models\Renting;

class Renter extends Model
{
    use HasFactory;
    protected $fillable = [
        "id", "nev", "szuletesi_datum"
    ];
    public $timestamps = false;
    public function rentings() {
        return $this->hasMany(Renting::class, 'foglalo_id', 'id');
    }
}
