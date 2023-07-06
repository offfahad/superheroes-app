package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.ui.theme.SuperheroesTheme

@Composable
fun HeroListItem(
    hero: Hero,
    modifier: Modifier = Modifier,
){
    Card(
        elevation = CardDefaults
            .cardElevation(defaultElevation = 2.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .sizeIn(minHeight = 72.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = stringResource(hero.nameRes), style = MaterialTheme.typography.displayMedium)
                Text(text = stringResource(hero.descriptionRes), style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(Modifier.width(16.dp))
            Box(modifier = Modifier
                .size(72.dp)
                .clip(
                    RoundedCornerShape(8.dp)
                )
            ){
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = null,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.Crop)
            }
        }
    }
}
@Preview("Light Theme")
@Composable
fun HeroPreview(){
    val hero = Hero(
        R.string.hero1,
        R.string.description1,
        R.drawable.android_superhero1
    )
    SuperheroesTheme {
        HeroListItem(hero = hero)
    }
}