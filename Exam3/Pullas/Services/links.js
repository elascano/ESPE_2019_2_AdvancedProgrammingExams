const express = require('express');
const router = express.Router();

const mysqlConnection = require('../databse');

router.get('/',(req, res)=>{
    res.send('hello w');
});

//metodos Get Simples

router.get('/transportista',(req,res)=>{
    mysqlConnection.query('SELECT * FROM transportista', (err, rows, fields)=>{
        if(!err){
            res.json(rows);
        }else{
            console.log(err); 
        }
    });
});


router.get('/Vehicle/getvehicles',(req, res)=>{
    mysqlConnection.query('SELECT * FROM Vehiculos', (err, rows, fields)=>{
        if(!err){
            res.json(rows);
        }else{
            console.log(err);
        }
    })
});


router.get('/detalleguia',(req,res)=>{
    mysqlConnection.query('SELECT * FROM detalleguia', (err, rows, fields)=>{
        if(!err){
            res.json(rows);
        }else{
            console.log(err); 
        }
    });
});



router.get('/cliente',(req,res)=>{
    mysqlConnection.query('SELECT * FROM cliente', (err, rows, fields)=>{
        if(!err){
            res.json(rows);
        }else{
            console.log(err); 
        }
    });
});


router.get('/cliente',(req,res)=>{
    mysqlConnection.query('SELECT * FROM cliente', (err, rows, fields)=>{
        if(!err){
            res.json(rows);
        }else{
            console.log(err); 
        }
    });
});


router.get('/zona',(req,res)=>{
    mysqlConnection.query('SELECT * FROM zona', (err, rows, fields)=>{
        if(!err){
            res.json(rows);
        }else{
            console.log(err); 
        }
    });
});

router.get('/producto',(req,res)=>{
    mysqlConnection.query('SELECT * FROM producto', (err, rows, fields)=>{
        if(!err){
            res.json(rows);
        }else{
            console.log(err); 
        }
    });
});



router.get('/ci/:ci',(req, res)=>{
    const {ci}= req.params;
    console.log(ci);
    mysqlConnection.query('SELECT * FROM cliente where ci = ?',[ci],(err, rows, fields)=>{
        if(!err){
            res.json(rows[0]);
        }else{
            console.log(err);
        }
    });
});

router.get('/Vehicle/getVehicleById/:ID',(req, res)=>{
    const{ID}= req.params;
    console.log(ID);
    mysqlConnection.query('SELECT * FROM Vehiculos where ID = ?',[ID],(err, rows, fields)=>{
        if(!err){
            res.json(rows[0]);
        }else{
            console.log(err);
        }
    })
});

router.get('/producto/:codigopro',(req, res)=>{
    const {codigopro}=req.params;
    mysqlConnection.query('SELECT * FROM producto WHERE codigopro=?',[codigopro],(err, rows, fields)=>{
        if(!err){
            res.json(rows[0]);
        }else{
            console.log(err); 
        }
    });
});

router.post('/codigozona',(req, res)=>{
    const{codigozona, nombrezona} = req.body;
    mysqlConnection.query(`INSERT INTO zona VALUES ('${codigozona}','${nombrezona}');`,(err, rows)=>{
        if(!err){
            res.status(200).json('ok');
        }else{
            console.log(err);
        }
    });
});




router.delete('/cliente/:ci',(req, res)=>{
    const {ci}= req.params;
    mysqlConnection.query('DELETE FROM cliente WHERE ci = ?',[ci],(err,rows,fields)=>{
        if(!err){
            res.json({status: 'Cliente Eliminado'});
        }else{
            console.log(err);
        }
    });
});

router.delete('/zona/:nombrezona',(req, res)=>{
    const {nombrezona}= req.params;
    mysqlConnection.query('DELETE FROM zona WHERE nombrezona = ?',[nombrezona],(err,rows,fields)=>{
        if(!err){
            res.json({status: 'Eliminado'});
        }else{
            console.log(err);
        }
    });
});

module.exports = router;