from django.shortcuts import render
from django.http import HttpResponse
from blog.models import *

# Create your views here.
def index(request):
    return HttpResponse("this is index")

def read(request, id=None):

    current_entry = Entries.objects.get(id=int(id))
    #return HttpResponse("this is read", kwargs)
    return HttpResponse("%d 글은 %s야" %(current_entry.id, current_entry.Title))