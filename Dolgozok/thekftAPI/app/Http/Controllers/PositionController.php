<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Position;

class PositionController extends Controller
{
    public function getPositions(){
        $positions = Position::all();

        return response()->json([
            "data" => $positions
        ]);
    }
    public function getOnePosition($id){
        $position = Position::find($id);

        return response()->json([
            "message" => "Sikeres lekérés!",
            "data" => $position
        ]);
    }
    public function getPositionId($name) {
        $position = Position::where("position_name", $name)->first();
        $id = $position->id;
        return $id;
    }
    
    
}
