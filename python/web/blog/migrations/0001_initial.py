# Generated by Django 2.1.2 on 2019-01-09 16:27

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Categories',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('Title', models.CharField(max_length=40)),
            ],
        ),
        migrations.CreateModel(
            name='Comments',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('Name', models.CharField(max_length=20)),
                ('Password', models.CharField(max_length=32)),
                ('Content', models.TextField(max_length=2000)),
                ('Created', models.DateTimeField(auto_now=True)),
            ],
        ),
        migrations.CreateModel(
            name='Entries',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('Title', models.CharField(max_length=80)),
                ('Content', models.TextField()),
                ('Created', models.DateTimeField(auto_now_add=True)),
                ('Comments', models.PositiveSmallIntegerField(default=0, null=True)),
                ('Category', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='blog.Categories')),
            ],
        ),
        migrations.CreateModel(
            name='TagModel',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('Title', models.CharField(max_length=20)),
            ],
        ),
        migrations.AddField(
            model_name='entries',
            name='Tags',
            field=models.ManyToManyField(to='blog.TagModel'),
        ),
    ]