# Generated by Django 2.0.3 on 2019-07-30 12:44

from django.conf import settings
import django.contrib.auth.models
import django.contrib.postgres.fields
from django.db import migrations, models
import django.db.models.deletion
import django.utils.timezone


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        ('auth', '0009_alter_user_last_name_max_length'),
    ]

    operations = [
        migrations.CreateModel(
            name='User',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('password', models.CharField(max_length=128, verbose_name='password')),
                ('last_login', models.DateTimeField(blank=True, null=True, verbose_name='last login')),
                ('is_superuser', models.BooleanField(default=False, help_text='Designates that this user has all permissions without explicitly assigning them.', verbose_name='superuser status')),
                ('is_staff', models.BooleanField(default=False, help_text='Designates whether the user can log into this admin site.', verbose_name='staff status')),
                ('is_active', models.BooleanField(default=True, help_text='Designates whether this user should be treated as active. Unselect this instead of deleting accounts.', verbose_name='active')),
                ('date_joined', models.DateTimeField(default=django.utils.timezone.now, verbose_name='date joined')),
                ('email', models.EmailField(max_length=254, unique=True)),
                ('username', models.CharField(max_length=30, unique=True)),
                ('first_name', models.CharField(max_length=30)),
                ('last_name', models.CharField(max_length=150)),
                ('date_of_birth', models.DateField()),
                ('registration_key', models.CharField(max_length=32, null=True, unique=True)),
                ('verified', models.BooleanField(default=False)),
                ('bio', models.CharField(blank=True, max_length=1000)),
                ('avatar', models.TextField(blank=True)),
                ('country', models.TextField(blank=True)),
                ('groups', models.ManyToManyField(blank=True, help_text='The groups this user belongs to. A user will get all permissions granted to each of their groups.', related_name='user_set', related_query_name='user', to='auth.Group', verbose_name='groups')),
                ('user_permissions', models.ManyToManyField(blank=True, help_text='Specific permissions for this user.', related_name='user_set', related_query_name='user', to='auth.Permission', verbose_name='user permissions')),
            ],
            options={
                'verbose_name': 'user',
                'verbose_name_plural': 'users',
                'abstract': False,
            },
            managers=[
                ('objects', django.contrib.auth.models.UserManager()),
            ],
        ),
        migrations.CreateModel(
            name='League',
            fields=[
                ('id', models.TextField(primary_key=True, serialize=False)),
                ('name', models.TextField()),
                ('start_date', models.DateField()),
                ('end_date', models.DateField()),
                ('active', models.BooleanField(default=False)),
                ('submissions_enabled', models.BooleanField(default=False)),
            ],
        ),
        migrations.CreateModel(
            name='Scrimmage',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('ranked', models.BooleanField(default=False)),
                ('status', models.TextField(choices=[('pending', 'Pending'), ('queued', 'Queued'), ('running', 'Running'), ('redwon', 'Red Won!'), ('bluewon', 'Blue Won!'), ('rejected', 'Rejected'), ('failed', 'Failed'), ('cancelled', 'Cancelled')], default='pending')),
                ('replay', models.TextField(blank=True)),
                ('requested_at', models.DateTimeField(auto_now_add=True)),
                ('started_at', models.DateTimeField(null=True)),
                ('updated_at', models.DateTimeField(auto_now=True)),
            ],
        ),
        migrations.CreateModel(
            name='Submission',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=150)),
                ('filename', models.TextField(default=None, null=True)),
                ('submitted_at', models.DateTimeField(auto_now_add=True)),
            ],
        ),
        migrations.CreateModel(
            name='Team',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=64)),
                ('team_key', models.CharField(max_length=16, unique=True)),
                ('avatar', models.TextField(blank=True)),
                ('bio', models.CharField(blank=True, max_length=1000)),
                ('divisions', django.contrib.postgres.fields.ArrayField(base_field=models.TextField(choices=[('highschool', 'High School'), ('newbie', 'Newbie'), ('college', 'College'), ('pro', 'Pro')]), default=list, size=None)),
                ('mu', models.FloatField(default=25)),
                ('sigma', models.FloatField(default=8.333)),
                ('auto_accept_ranked', models.BooleanField(default=False)),
                ('auto_accept_unranked', models.BooleanField(default=False)),
                ('wins', models.IntegerField(default=0)),
                ('losses', models.IntegerField(default=0)),
                ('draws', models.IntegerField(default=0)),
                ('code', models.TextField(default='// Get started by reading the docs!')),
                ('deleted', models.BooleanField(default=False)),
                ('league', models.ForeignKey(on_delete=django.db.models.deletion.PROTECT, to='api.League')),
                ('users', models.ManyToManyField(default=list, to=settings.AUTH_USER_MODEL)),
            ],
        ),
        migrations.CreateModel(
            name='Tournament',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.TextField()),
                ('style', models.TextField(choices=[('trueskill', 'TrueSkill'), ('singleelim', 'Single Elimination'), ('doubleelim', 'Double Elimination')])),
                ('date_time', models.DateTimeField()),
                ('divisions', django.contrib.postgres.fields.ArrayField(base_field=models.TextField(choices=[('highschool', 'High School'), ('newbie', 'Newbie'), ('college', 'College'), ('pro', 'Pro')]), blank=True, default=list, size=None)),
                ('stream_link', models.TextField(blank=True)),
                ('hidden', models.BooleanField(default=True)),
                ('league', models.ForeignKey(on_delete=django.db.models.deletion.PROTECT, to='api.League')),
            ],
        ),
        migrations.CreateModel(
            name='TournamentScrimmage',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('round', models.IntegerField(null=True)),
                ('subround', models.CharField(max_length=1, null=True)),
                ('index', models.IntegerField(null=True)),
                ('hidden', models.BooleanField(default=True)),
                ('winner_hidden', models.BooleanField(default=True)),
                ('blue_from', models.ForeignKey(default=None, null=True, on_delete=django.db.models.deletion.SET_DEFAULT, related_name='+', to='api.TournamentScrimmage')),
                ('red_from', models.ForeignKey(default=None, null=True, on_delete=django.db.models.deletion.SET_DEFAULT, related_name='+', to='api.TournamentScrimmage')),
                ('scrimmage', models.OneToOneField(on_delete=django.db.models.deletion.PROTECT, to='api.Scrimmage')),
                ('tournament', models.ForeignKey(on_delete=django.db.models.deletion.PROTECT, to='api.Tournament')),
            ],
        ),
        migrations.CreateModel(
            name='Update',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('message', models.CharField(blank=True, max_length=1000)),
                ('time', models.DateTimeField(auto_now_add=True)),
                ('league', models.ForeignKey(on_delete=django.db.models.deletion.PROTECT, related_name='updates', to='api.League')),
            ],
        ),
        migrations.AddField(
            model_name='submission',
            name='team',
            field=models.ForeignKey(on_delete=django.db.models.deletion.PROTECT, to='api.Team'),
        ),
        migrations.AddField(
            model_name='scrimmage',
            name='blue_team',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.PROTECT, related_name='blue_team', to='api.Team'),
        ),
        migrations.AddField(
            model_name='scrimmage',
            name='league',
            field=models.ForeignKey(on_delete=django.db.models.deletion.PROTECT, to='api.League'),
        ),
        migrations.AddField(
            model_name='scrimmage',
            name='red_team',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.PROTECT, related_name='red_team', to='api.Team'),
        ),
        migrations.AddField(
            model_name='scrimmage',
            name='requested_by',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.PROTECT, related_name='requested_by', to='api.Team'),
        ),
    ]