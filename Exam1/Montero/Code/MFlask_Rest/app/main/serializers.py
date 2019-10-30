from .plugins import ma
from .models import Product


class ProductSerializer(ma.ModelSchema):

    class Meta:
        model = Product
        fields = ('_id', 'description', 'quantity', 'name', 'price')