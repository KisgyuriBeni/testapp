<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\RoomController;
use App\Http\Controllers\RenterController;
use App\Http\Controllers\RentingController;

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

Route::get('/szobak', [RoomController::class, "getRooms" ]);
Route::get('/szobak/{id}', [RoomController::class, "getOneRoom" ]);
Route::post('/addszobak', [RoomController::class, "createNewRoom"]);
Route::put('/szobak/{id}', [RoomController::class, 'updateRoom']);
Route::delete('/deleteszobak/{id}', [RoomController::class, 'deleteRoom']);

Route::get('/foglalok', [RenterController::class, "getRenters"]);
Route::get('/foglalo/{id}', [RenterController::class, "getOneRenter"]);

Route::get('/foglalasok', [RentingController::class, "getRentings"]);
Route::get('/foglalas/{id}', [RentingController::class, "getRenting"]);
Route::post('/leadfoglalas', [RentingController::class, "addRenting"]);
Route::delete('/torolfoglalas/{id}', [RentingController::class, "deleteRenting"]);