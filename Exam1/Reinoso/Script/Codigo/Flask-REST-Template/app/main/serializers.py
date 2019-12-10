from .plugins import ma
from .models import Product

class SimpleProductSerializer(ma.ModelSchema):
    class Meta:
        model = Product
        fields = ('_id', 'name', 'description', 'qty', 'price')