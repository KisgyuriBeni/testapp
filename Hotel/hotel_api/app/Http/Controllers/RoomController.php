<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Room;

class RoomController extends Controller
{
    
    public function getRooms(){

        $rooms = Room::all();

        return response()->json([
            "data" => $rooms
        ]);
    }
    public function getOneRoom($id){

        $room = Room::find($id);

        return response()->json([
            "message" => "Sikeres lekérés!",
            "data" => $room
        ]);
    }
    public function createNewRoom(Request $request){
        $input = $request->all();
        $room = new Room;

        $room -> szoba_szam = $input["szoba_szam"];
        $room -> szoba_merete = $input["szoba_merete"];
        $room -> agyak_szama = $input["agyak_szama"];
        $room -> terasz = $input["terasz"];
        $room -> haziallat = $input["haziallat"];

        $room->save();

        return response()->json([
            "message" => "Sikeresen felvett új szoba!"
        ]);
    }
    public function updateRoom(Request $request, $id){
        $input = $request->all();
        $room = Room::find($id);

        $room -> szoba_szam = $input["szoba_szam"];
        $room -> szoba_merete = $input["szoba_merete"];
        $room -> agyak_szama = $input["agyak_szama"];
        $room -> terasz = $input["terasz"];
        $room -> haziallat = $input["haziallat"];

        $room->save();
        return response()->json([
            "message" => "Sikeresen frissített szoba!",
            "data" => $room
        ]);
    }
    public function deleteRoom($id){
        $room = Room::find($id);
        $room->delete();
        return response()->json([
            "message" => "Szobak törölve"
    ]);
    }

}
