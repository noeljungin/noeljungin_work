from rest_framework import serializers
from noel.models import Post, Category, MyUser

class PostSerializer(serializers.ModelSerializer):
    class Meta:
        model = Post
        fields = '__all__'