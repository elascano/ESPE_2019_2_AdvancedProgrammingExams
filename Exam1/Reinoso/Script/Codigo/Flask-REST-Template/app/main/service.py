from flask import Blueprint, request, jsonify
from app.constants import GET, POST
from .plugins import db
from .models import Product
from .serializers import SimpleProductSerializer

urls = Blueprint('urls', __name__)


@urls.route('/producto', methods=POST)
def create_producto():
    producto_serializer = SimpleProductSerializer()
    new_producto = producto_serializer.load(request.json, partial=True)
    db.session.add(new_producto)
    db.session.commit()

    return producto_serializer.jsonify(new_producto), 201

