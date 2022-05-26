var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Medida = require('../models').Medida;

var tempo = 0;

let instrucaoSql = `SELECT usage, measurement_date from measurement where measurement_date > DATEADD(mi, -185, GETDATE()) and fk_component = 1;`


router.get('/recuperar', function(req, res, next) {
sequelize.query(instrucaoSql, {
	model: Medida 
})
.then(resultado => {
	console.log(`Encontrados: ${resultado.length}`);
	res.json(resultado);
}).catch(erro => {
	console.error(erro);
	res.status(500).send(erro.message);
});
});

module.exports = router;