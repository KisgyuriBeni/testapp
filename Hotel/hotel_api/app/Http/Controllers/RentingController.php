<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Renting;

class RentingController extends Controller
{
    public function getRentings(){
        $rentings = Renting::with([
            'renter:id,nev,szuletesi_datum', 
            'room:id,szoba_szam,szoba_merete,agyak_szama,terasz,haziallat'
            ])->get()->map(function($renting) {
            return [
                'id' => $renting->id,
                'renter' => [
                    'id' => $renting->renter->id,
                    'nev' => $renting->renter->nev,
                    'szuletesi_datum'=> $renting->renter->szuletesi_datum
                ],
                'szoba' => [
                    'id' => $renting->room->id,
                    'szam' => $renting->room->szoba_szam,
                    'merete'=>$renting->room->szoba_merete,
                    'ferohely'=>$renting->room->agyak_szama,
                    'terasz'=>$renting->room->terasz,
                    'haziallat'=>$renting->room->haziallat
                ],
                'foglalas_eleje' => $renting->foglalas_eleje,
                'foglalas_vege' => $renting->foglalas_vege
            ];
        });
    
        return response()->json([
            "data" => $rentings
        ]);
    }
    public function getRenting($id){
        $renting = Renting::with(
            'renter:id,nev,szuletesi_datum', 
            'room:id,szoba_szam,szoba_merete,agyak_szama,terasz,haziallat'
        )->find($id);
    
        $formattedRenting = [
            'id' => $renting->id,
            'foglalo' => [
                'id' => $renting->renter->id,
                'nev' => $renting->renter->nev,
                'szuletesi_datum' => $renting->renter->szuletesi_datum,
            ],
            'szoba' => [
                'id' => $renting->room->id,
                'szam' => $renting->room->szoba_szam,
                'merete' => $renting->room->szoba_merete,
                'ferohely' => $renting->room->agyak_szama,
                'terasz' => $renting->room->terasz,
                'haziallat' => $renting->room->haziallat,
            ],
            'foglalas_eleje'=>$renting->foglalas_eleje,
            'foglalas_vege'=>$renting->foglalas_vege,
        ];
    
        return response()->json([
            "data" => $formattedRenting
        ]);
    }
    public function addRenting(Request $request){
        $input = $request->all();
        $renting = new Renting;
    
        $renting->szoba_id = $request->input('szoba_id');
        $renting->foglalo_id = $request->input('foglalo_id');
        $renting->foglalas_eleje = $request->input('foglalas_eleje');
        $renting->foglalas_vege = $request->input('foglalas_vege');
    
        $renting->save();
        return response()->json([
            "message" => "Sikeresen felvett foglalás!"
        ]);
    }
    public function deleteRenting($id){
        $renting = Renting::find($id);
        $renting->delete();
        return response()->json([
            "message"=>"Foglalás törölve!"
        ]);
    }
}
