from django.db import models

class Accounts(models.Model):
    identify = models.CharField(default='identify', max_length=20)
    password = models.CharField(default='password', max_length=20)
