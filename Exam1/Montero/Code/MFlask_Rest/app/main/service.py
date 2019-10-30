from flask import Response, Blueprint, request, jsonify
from app.constants import GET, POST, PUT
from .models import Product
from .serializers import ProductSerializer
from .functions import get_all
from .plugins import db

urls = Blueprint('urls', __name__)

#define your routes here

@urls.route('/producto', methods=POST)
def create_product():
    try:
        product_serializer = ProductSerializer()
        new_product = product_serializer.load(request.json)
        db.session.add(new_product)
        db.session.commit()
        return product_serializer.jsonify(new_product), 201
    except Exception:
        return Response(status=400)


@urls.route('/producto/', methods=GET)
def get_produtcs():
    product_serializer = ProductSerializer(Many=True)
    products = Product.query.all()
    serialized_products = product_serializer.dump(products)
    return jsonify(serialized_products)

@urls.route('/producto/id/<_id>', methods=GET)
def get_product_by_id(_id):
    product = Product()
    product_serializer = ProductSerializer()
    return product_serializer.jsonify(product) if product._id else Response(status=404)
