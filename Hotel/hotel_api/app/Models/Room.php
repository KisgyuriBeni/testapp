<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use App\Models\Renting;

class Room extends Model
{
    use HasFactory;
    protected $fillable = [
        "id", "szoba_szam", "szoba_merete", "agyak_szama", "terasz", "haziallat"
    ];
    public $timestamps = false;
    public function rentings() {
        return $this->hasMany(Renting::class, 'szoba_id', 'id');
    }
}
